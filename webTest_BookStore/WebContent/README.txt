功能分析：
	*前台
		1.用户模块
			注册
			激活
			登录
			退出
		2.分类模块
			查看所有分类
		3.图书模块
			查询所有分类
			按分类查询
			查询书籍详细页（按id查询）
		4.购物车模块
			添加购物车条目
			清空所有条目
			删除指定条目
			我的购物车
		5.订单模块
			生成订单
			我的订单
			按id查询订单
			确认收货
			付款（跳转到银行页面）
			付款回调（由银行调用，表示用户付款成功）
	*后台
		1.管理员
			登录
		2.分类管理
			查看分类
			添加分类
			删除分类
			按id查询分类
			修改分类
		3.图书管理
			查看所有图书
			按id查询图书
			删除图书
			修改图书
			添加图书
		4.订单模块
			查询所有图书
			按状态查询订单
			发货
环境搭建
	1.数据库
		mysql驱动
		c3p0及其配置文件
		dbutils
		itcast-tools
			依赖：commons-beanUtils
				commons-io
	2.javamail
		mail.jar
		activation.jar
	3.上传
		commons-fileupload
		commons-io
	4.ajax
		json-lib
		
					