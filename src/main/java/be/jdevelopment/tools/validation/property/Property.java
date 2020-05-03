package be.jdevelopment.tools.validation.property;

public interface Property<T> {

    /* Upper monad structure reference */

    MonadOfProperties upperMonadStructureReference();

    /* Monad interface */

    @FunctionalInterface
    interface MaybeMap<U, V> {
        V apply(U arg);
    }

    <U> Property<U> flatMap(MaybeMap<? super T, ? extends Property<? extends U>> f);

    <U> Property<U> map(MaybeMap<? super T, ? extends U> f);

    @FunctionalInterface
    interface MaybePredicate<U> {
        boolean test(U arg);
    }

    Property<T> filter(MaybePredicate<? super T> predicate);

    Property<T> registerFailureCode(String code);

    /** Failure of Success discrimination */

    boolean isFailure();

    @FunctionalInterface
    interface MaybeMatch<U, V> {
        V apply(PropertyState sate, U arg);
    }
    <U> Property<U> match(MaybeMatch<? super T, ? extends Property<? extends U>> f);

}
