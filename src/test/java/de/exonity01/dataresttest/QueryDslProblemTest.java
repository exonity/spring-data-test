package de.exonity01.dataresttest;

import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.StringExpression;
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

        System.out.println(findByProductName("free").size()); // => 1
        System.out.println(findByProductName2("free").size()); // => 0 ?!?!?! Wieso wird in diesem fall plötzlich .otherwise ausgeführt?
    }


    private List<MarketRow> findByProductName(String filter) {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QMarketRow qMarketRow = QMarketRow.marketRow;

        StringExpression stringExpression = new CaseBuilder()
                .when(qMarketRow.productFreeText.isNotEmpty())
                .then(qMarketRow.productFreeText)
                .otherwise(qMarketRow.id.toString()); // Changes

        JPAQuery<MarketRow> query = jpaQueryFactory
                .selectFrom(qMarketRow)
                .where(stringExpression.contains(filter));

        return query.fetch();
    }

    private List<MarketRow> findByProductName2(String filter) {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QMarketRow qMarketRow = QMarketRow.marketRow;

        StringExpression stringExpression = new CaseBuilder()
                .when(qMarketRow.productFreeText.isNotEmpty())
                .then(qMarketRow.productFreeText)
                .otherwise(qMarketRow.product.productName);

        JPAQuery<MarketRow> query = jpaQueryFactory
                .selectFrom(qMarketRow)
                .where(stringExpression.contains(filter)); // Changes

        return query.fetch();
    }
}
