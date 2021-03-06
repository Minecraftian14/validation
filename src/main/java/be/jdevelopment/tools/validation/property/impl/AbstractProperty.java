package be.jdevelopment.tools.validation.property.impl;

import be.jdevelopment.tools.validation.error.FailureBuilder;
import be.jdevelopment.tools.validation.property.MonadOfProperties;
import be.jdevelopment.tools.validation.property.Property;

abstract class AbstractProperty<T> implements Property<T> {

    enum STATE {
        SUCCESS, FAIL_UNCUT, FAIL_CUT;
    }

    STATE state;
    final MonadStructure structure;
    AbstractProperty(STATE state, MonadStructure structure) {
        this.state = state;
        this.structure = structure;
    }

    MonadOfProperties upperMonadStructureReference() {
        return structure;
    }

    FailureBuilder upperBuilderReference() {
        return structure.builder;
    }
}
