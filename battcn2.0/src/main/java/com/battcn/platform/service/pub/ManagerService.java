package com.battcn.platform.service.pub;

import com.battcn.platform.entity.pub.ManagerEntity;

public interface ManagerService {
	ManagerEntity selectByAccount(String account);
}
