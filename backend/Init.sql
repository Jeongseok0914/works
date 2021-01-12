CREATE TABLE `role_info` (
  `role_id` varchar(20) NOT NULL COMMENT '역할 아이디',
  `role_nm` varchar(100) DEFAULT NULL COMMENT '역할명',
  `use_yn` varchar(1) DEFAULT NULL COMMENT '사용여부',
  `role_desc` varchar(500) DEFAULT NULL COMMENT '역할설명',
  `sys_cret_date` datetime NOT NULL COMMENT '등록일자',
  `sys_cret_user_id` varchar(20) NOT NULL COMMENT '등록자',
  `sys_updt_date` datetime NOT NULL COMMENT '수정일자',
  `sys_updt_user_id` varchar(20) NOT NULL COMMENT '수정자',
  PRIMARY KEY(`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='역할 정보 테이블';


CREATE TABLE `user_info` (
	`user_id` varchar(20) NOT NULL COMMENT '사용자 아이디',
	`user_password` varchar(100) NOT NULL COMMENT '사용자 비밀번호',
	`user_name` varchar(10) NOT NULL COMMENT '사용자 이름',
	`sys_cret_date`	datetime NOT NULL COMMENT '등록일자',
	`sys_updt_date` datetime DEFAULT NULL COMMENT '수정일자',
	PRIMARY KEY(`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '사용자 정보 테이블';

INSERT INTO user_info (user_id, user_password, user_name, sys_cret_date, sys_updt_date) VALUES('test1', 'asdf', '요청자', sysdate(), NULL);
INSERT INTO user_info (user_id, user_password, user_name, sys_cret_date, sys_updt_date) VALUES('test2', 'asdf', '결재자', sysdate(), NULL);

CREATE TABLE `user_role_rel` (
	`user_id` varchar(20) NOT NULL COMMENT '사용자 아이디',
	`role_id` varchar(20) NOT NULL COMMENT '역할 아이디',
	`sys_cret_date` datetime NOT NULL COMMENT '등록일자',
  	`sys_cret_user_id` varchar(20) NOT NULL COMMENT '등록자',
  	`sys_updt_date` datetime NOT NULL COMMENT '수정일자',
  	`sys_updt_user_id` varchar(20) NOT NULL COMMENT '수정자',
  	PRIMARY KEY(`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


