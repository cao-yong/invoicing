package com.invoicing.core.bean.system;

import com.invoicing.core.bean.base.BaseQuery;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoleQueryDTO extends BaseQuery {

    private static final long serialVersionUID = -2511039017160261046L;

    private String            name;
}
