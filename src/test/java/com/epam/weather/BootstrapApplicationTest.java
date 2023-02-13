package com.epam.weather;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.epam.weather.core.IObserver;
import com.epam.weather.core.ReportService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootstrapApplication.class)
class BootstrapApplicationTest {

    @Autowired
    private ReportService reportService;

    @Test
    void testBootstrap() throws InterruptedException {
        List<IObserver> observer = reportService.getObservers();
        Assert.assertEquals(4, observer.size());
    }

    @Test
    void testNotInitSix() {
        List<IObserver> observer = reportService.getObservers();
        try {
            observer.get(5);
            Assert.fail("Station6 Not yet implemented");
        } catch (Exception e) {
            Assert.assertTrue(e instanceof IndexOutOfBoundsException);
        }
    }

}
