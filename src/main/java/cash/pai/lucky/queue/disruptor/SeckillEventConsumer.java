package cash.pai.lucky.queue.disruptor;

import cash.pai.lucky.common.config.SpringUtil;
import cash.pai.lucky.service.ISeckillService;
import com.lmax.disruptor.EventHandler;

/**
 * 消费者(秒杀处理器)
 * 创建者 科帮网
 */
public class SeckillEventConsumer implements EventHandler<SeckillEvent> {
	
	private ISeckillService seckillService = (ISeckillService) SpringUtil.getBean("seckillService");
	
	@Override
    public void onEvent(SeckillEvent seckillEvent, long seq, boolean bool) {
		seckillService.startSeckil(seckillEvent.getSeckillId(), seckillEvent.getUserId());
	}
}
