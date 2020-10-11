package com.bupt.ims.service;

import com.bupt.ims.common.lang.Result;
import com.bupt.ims.entity.Admin;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AdminService {

    boolean login(Long id, String password);

    Result account2DataBase(MultipartFile file, String entity) throws IOException;
}
