package org.prgrms.kdt.order;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//@Component
@Configuration
@ConfigurationProperties(prefix = "kdt")
public class OrderProperties implements InitializingBean {

    //    @Value("${kdt.version}")
    private String version;

    //    @Value("${kdt.minimum-order-amount}")
    private int minimumOrderAmount;

    //    @Value("${kdt.support-vendors}")
    private List<String> supportVendors;

    //    @Value("${kdt.version2:v0.0.0}")
    private String description;

    @Value("${JAVA_HOME}")
    private String javaHome;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("OrderProperties.afterPropertiesSet");
        System.out.println("version = " + version);
        System.out.println("minimumOrderAmount = " + minimumOrderAmount);
        System.out.println("supportVendors = " + supportVendors);
        System.out.println("description = " + description);
        System.out.println("javaHome = " + javaHome);
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getMinimumOrderAmount() {
        return minimumOrderAmount;
    }

    public void setMinimumOrderAmount(int minimumOrderAmount) {
        this.minimumOrderAmount = minimumOrderAmount;
    }

    public List<String> getSupportVendors() {
        return supportVendors;
    }

    public void setSupportVendors(List<String> supportVendors) {
        this.supportVendors = supportVendors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
