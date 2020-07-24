package cash.pai.lucky.service;

import cash.pai.lucky.common.entity.RedPacket;
import cash.pai.lucky.common.entity.Result;

public interface IRedPacketService {

    /**
     * 获取红包
     * @param redPacketId
     * @return
     */
    RedPacket get(long redPacketId);
	/**
	 * 抢红包业务实现
	 * @param redPacketId
	 * @return
	 */
	Result startSeckil(long redPacketId, int userId);

    /**
     * 微信抢红包业务实现
     * @param redPacketId
     * @param userId
     * @return
     */
    Result startTwoSeckil(long redPacketId,int userId);

}
