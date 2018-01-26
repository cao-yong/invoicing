package com.invoicing.core.bean.system;

import java.io.Serializable;

import com.invoicing.core.bean.base.BaseQuery;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserQueryDTO extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 2430404464111534668L;

    private String            username;
}
