
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `${tablePre}${proClassUpper}`
-- ----------------------------
DROP TABLE IF EXISTS `${tablePre}${proClassUpper}`;
CREATE TABLE `${tablePre}${proClassUpper}` (
 		`${proClassUpper}_ID` varchar(100) NOT NULL,
	<#list fieldList as var>
		<#if var[1] == 'Integer'>
		`${var[0]}` int(11) NOT NULL COMMENT '${var[2]}',
		<#else>
		`${var[0]}` varchar(255) DEFAULT NULL COMMENT '${var[2]}',
		</#if>
	</#list>
  		PRIMARY KEY (`${proClassUpper}_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
