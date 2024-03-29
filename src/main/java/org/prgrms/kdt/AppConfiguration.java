package org.prgrms.kdt;

import org.prgrms.kdt.configuration.YamlPropertiesFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"org.prgrms.kdt.order", "org.prgrms.kdt.voucher", "org.prgrms.kdt.configuration"})
//@ComponentScan(basePackageClasses = {Order.class, Voucher.class})
//@ComponentScan(basePackages = {"org.prgrms.kdt.voucher"},
//		excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = MemoryVoucherRepository.class)})
//@PropertySource("application.properties")
@PropertySource(value = "application.yaml", factory = YamlPropertiesFactory.class)
@EnableConfigurationProperties
public class AppConfiguration {

/*	@Bean(initMethod = "init")
	public BeanOne beanOne() {
		return new BeanOne();
	}*/
}

/*
class BeanOne implements InitializingBean {

	public void init() {
		System.out.println("[BeanOne] init called!");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("[BeanOne] afterPropertiesSet called!");
	}
}
*/
