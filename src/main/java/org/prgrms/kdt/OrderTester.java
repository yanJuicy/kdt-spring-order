package org.prgrms.kdt;

import org.prgrms.kdt.order.Order;
import org.prgrms.kdt.order.OrderItem;
import org.prgrms.kdt.order.OrderService;
import org.prgrms.kdt.voucher.FixedAmountVoucher;
import org.prgrms.kdt.voucher.Voucher;
import org.prgrms.kdt.voucher.VoucherRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.UUID;

public class OrderTester {

	public static void main(String[] args) {
		var applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);

		var customerId = UUID.randomUUID();
		var voucherRepository = applicationContext.getBean(VoucherRepository.class);
		Voucher voucher = voucherRepository.insert(new FixedAmountVoucher(UUID.randomUUID(), 10L));
		var orderService = applicationContext.getBean(OrderService.class);
		Order order = orderService.createOrder(customerId, new ArrayList<>() {{
			add(new OrderItem(UUID.randomUUID(), 100L, 1));
		}}, voucher.getVoucherId());

		Assert.isTrue(order.totalAmount() == 90L, MessageFormat.format("totalAmount {0} is not 100L", order.totalAmount()));
	}

}
