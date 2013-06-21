package com.app.meibo.message.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.app.meibo.message.model.Message;
import com.app.permission.model.Role;
import com.app.permission.model.User;
import com.sqds.hibernate.HibernateDao;
import com.sqds.page.PageInfo;

/**
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-11-27 下午11:46:36
 */
@Service
public class MessageManager extends HibernateDao<Message> {
	/**
	 * 对角色发送消息
	 * 
	 * @param role
	 *            角色
	 * @param title
	 *            标题
	 * @param content
	 *            内容
	 */
	public void sendMessageToRole(Role role, String title, String content) {

	}

	/**
	 * 对用户发送消息
	 * 
	 * @param user
	 * @param title
	 * @param content
	 */
	public void sendMessageToUser(User user, String title, String content) {

	}

	/**
	 * 查询用户的所有消息，
	 * 
	 * @param id
	 * @param isRead
	 *            -1:查询所有；0：只查询未读；1：只查询已读
	 * @return
	 */
	public List<Message> listMessageByUserId(Integer userId, int isRead) {
		String hql = "select m from Message m join m.users u where u.id = ?";
		if (0 == isRead) {
			hql = hql + " and m.isRead = 0";
		} else if (1 == isRead) {
			hql = hql + " and m.isRead = 1";
		}
		hql = hql + " and m.isDelete = 0";
		return list(hql, userId);
	}

	public PageInfo<Message> search(PageInfo<Message> pageInfo, String nowClick, User user) {
		StringBuffer hql = new StringBuffer();
		String titleKey = pageInfo.getStringParameter("title");
		String content = pageInfo.getStringParameter("content");
		hql.append("select m from Message m ");
		if ("_read".equals(nowClick)) {// 已读
			hql.append(" join m.users u where u.id = ?");
			hql.append(" and m.isRead = 1 and m.isDelete = 0");
		} else if ("_noRead".equals(nowClick)) {// 未读
			hql.append(" join m.users u where u.id = ?");
			hql.append(" and m.isRead = 0 and m.isDelete = 0");
		} else if ("_send".equals(nowClick)) {// 已发
			hql.append(" where m.sendUserId = ? and m.isDelete = 0");
		} else if ("_delete".equals(nowClick)) {// 已删除
			hql.append(" join m.users u where (u.id = ?");
			hql.append(" or m.sendUserId = ?" + ") and m.isDelete = 1");
		}
		if (StringUtils.isNotEmpty(titleKey)) {
			hql.append(" and u.title like '%" + titleKey + "%'");
		}
		if (StringUtils.isNotEmpty(content)) {
			hql.append(" and u.content like '%" + content + "%'");
		}
		hql.append(" order by m.createDate desc");
		if ("_delete".equals(nowClick)) {
			return list(pageInfo, hql.toString(), user.getId(), user.getId());
		} else {
			return list(pageInfo, hql.toString(), user.getId());
		}
	}

	/**
	 * 获得用户总消息数和未读消息数
	 * 
	 * @return
	 */
	public int[] getAllAndNotReadCount(User user) {
		List<Message> readMsgs = this.listMessageByUserId(user.getId(), 1);
		List<Message> noReadMsgs = this.listMessageByUserId(user.getId(), 0);
		int[] msgArr = { readMsgs.size() + noReadMsgs.size(), noReadMsgs.size() };
		return msgArr;
	}
}
