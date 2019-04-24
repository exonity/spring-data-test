package de.exonity01.dataresttest;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import de.exonity01.dataresttest.querydslproblem.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryDslProblemTest {

    @Autowired
    MarketRowRepository marketRowRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    public void test() {
        Product product = new Product();
        product.setProductName("TEST1");
        productRepository.save(product);

        // Row 1
        MarketRow marketRow = new MarketRow();
        marketRow.setProduct(product);
        marketRowRepository.save(marketRow);

        // Row 2
        MarketRow marketRow2 = new MarketRow();
        marketRow2.setProductFreeText("free text");
        marketRowRepository.save(marketRow2);

        System.out.println(findByProductName("free").size());
    }


    private List<MarketRow> findByProductName(String filter) {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QMarketRow qMarketRow = QMarketRow.marketRow;

        JPAQuery<MarketRow> query = jpaQueryFactory
                .selectFrom(qMarketRow)
                .where(
                        qMarketRow.product.isNotNull().and(qMarketRow.product.productName.contains(filter))
                                .or(qMarketRow.product.isNull().and(qMarketRow.productFreeText.contains(filter)))
                );

        return query.fetch();
    }
}
