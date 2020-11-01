package io.github.jaymzee.categorytheory;
// Category Theory for Sum
//
//    A--inl-->A+B<--inr--B
//     \        .        /
//       \    [f,g]    /
//       f \    .    / g
//           \  .  /
//             vvv
//              C
//
// Haskell snippet
//   (type summation is built-in using data and pattern matching)
//
//   data DoubleOrBool = Inl Double | InR Bool
//
//   ... case value of
//           Inl x -> f x
//           Inr y -> g y
//          where value = Inl 3.14
//
// Java snippet (using this library)
//   Sum<Double,Boolean> value = new Inl<>(3.14)
//
//   ... value.caseExpr(f, g)
//
import java.util.function.Function;

public class Inr<A,B> implements Sum<A,B> {
    private B y;

    public Inr(B y) {
        this.y = y;
    }

    public <C> C caseExpr(Function<A,C> f, Function<B,C> g) {
        return g.apply(y);
    }

    public String toString() {
        return String.format("[Inr (%s)]", y);
    }
}
