package com.invoicing.core.bean.system;

import com.invoicing.core.bean.base.BaseQuery;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MenuQueryDTO extends BaseQuery {
    private static final long serialVersionUID = -1508230103327807094L;

    private String            name;
}
