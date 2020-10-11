package com.bupt.ims.common.util;

import org.springframework.boot.system.ApplicationHome;

import java.io.File;
import java.io.IOException;

public class FileManagement {

    public String mkdir(String name) {
        String root = getRoot() + File.separator + name;
        File mk = new File(root);
        if (mk.mkdirs()) {
            
        }
        return root;
    }

    public String getRoot() {
        ApplicationHome h = new ApplicationHome(getClass());
        File f = h.getSource();
        return f.getParentFile().toString();
    }
}
