package com.sample.workshopcassandra.model.embedded;

import com.sample.workshopcassandra.model.enums.PropType;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("prop")
public class Prop {

    private String name;

    private String value;

    private PropType propType;

    public Prop(String name, String value, PropType propType) {
        this.name = name;
        this.value = value;
        this.propType = propType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public PropType getPropType() {
        return propType;
    }

    public void setPropType(PropType propType) {
        this.propType = propType;
    }
}
