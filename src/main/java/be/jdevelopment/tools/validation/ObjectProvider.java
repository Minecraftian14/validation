package be.jdevelopment.tools.validation;

@FunctionalInterface
public interface ObjectProvider {

    Object provideFor(PropertyToken propertyToken);

}
