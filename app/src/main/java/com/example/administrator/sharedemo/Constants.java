package com.example.administrator.sharedemo;

public class Constants {
    public static final String APP_ID = "wx762f07f19c6a5cd3";
	public static  final String QQAPPID="222222";
    public static class ShowMsgActivity {
		public static final String STitle = "showmsg_title";
		public static final String SMessage = "showmsg_message";
		public static final String BAThumbData = "showmsg_thumb_data";
	}

	public static final String APP_KEY      = "2045436852";

	/**
	 * ��ǰ DEMO Ӧ�õĻص�ҳ��������Ӧ�ÿ���ʹ���Լ��Ļص�ҳ��
	 *
	 * <p>
	 * ע��������Ȩ�ص�ҳ���ƶ��ͻ���Ӧ����˵���û��ǲ��ɼ��ģ����Զ���Ϊ������ʽ������Ӱ�죬
	 * ����û�ж��彫�޷�ʹ�� SDK ��֤��¼��
	 * ����ʹ��Ĭ�ϻص�ҳ��https://api.weibo.com/oauth2/default.html
	 * </p>
	 */
	public static final String REDIRECT_URL = "http://www.sina.com";

	/**
	 * Scope �� OAuth2.0 ��Ȩ������ authorize �ӿڵ�һ��������ͨ�� Scope��ƽ̨�����Ÿ����΢��
	 * ���Ĺ��ܸ������ߣ�ͬʱҲ��ǿ�û���˽�������������û����飬�û����� OAuth2.0 ��Ȩҳ����Ȩ��
	 * ѡ����Ӧ�õĹ��ܡ�
	 *
	 * ����ͨ������΢������ƽ̨-->��������-->�ҵ�Ӧ��-->�ӿڹ������ܿ�������Ŀǰ������Щ�ӿڵ�
	 * ʹ��Ȩ�ޣ��߼�Ȩ����Ҫ�������롣
	 *
	 * Ŀǰ Scope ֧�ִ����� Scope Ȩ�ޣ��ö��ŷָ���
	 *
	 * �й���Щ OpenAPI ��ҪȨ�����룬��鿴��http://open.weibo.com/wiki/%E5%BE%AE%E5%8D%9AAPI
	 * ���� Scope ���ע�������鿴��http://open.weibo.com/wiki/Scope
	 */
	public static final String SCOPE =
			"email,direct_messages_read,direct_messages_write,"
					+ "friendships_groups_read,friendships_groups_write,statuses_to_me_read,"
					+ "follow_app_official_microblog," + "invitation_write";
}
