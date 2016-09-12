CREATE TABLE IF NOT EXISTS `t_question` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT ' 主键',
  `TYPE_ID` int(11) NOT NULL COMMENT '问题类型',
  `USER_ID` int(11) NOT NULL COMMENT '问题提交人',
  `QUESTION` varchar(255) NOT NULL COMMENT '问题描述',
  `SOLVED` text NOT NULL COMMENT '解决思路',
  `REFRERENCE` varchar(255) DEFAULT NULL COMMENT '参考资料',
  `CREATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `STATUS` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态（1：正常，0：删除）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `t_type` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `NAME` varchar(20) NOT NULL COMMENT '类型名称',
  `DESCRIPTIONS` varchar(255) NOT NULL COMMENT '类型描述',
  `NUMBER` int(11) NOT NULL DEFAULT '0' COMMENT '问题类型发生的数量',
  `CREATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `STATUS` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态（1：正常，0：删除）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `t_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `PASSWORD` varchar(100) NOT NULL COMMENT '密码',
  `NAME` varchar(20) NOT NULL COMMENT '用户名',
  `PHONE` varchar(20) NOT NULL COMMENT '手机号码',
  `EMAIL` varchar(20) NOT NULL COMMENT '电子邮箱',
  `CREATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `STATUS` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;