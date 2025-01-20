package module7;

public class Foo {

    public static void main(String[] args) {
        Foo newFoo = new Foo.Builder().setFoo("asdasd").setBar("trtretert").build();
    }

    private final String foo;
    private final String bar;

    private Foo(Builder builder) {
        this.foo = builder.foo;
        this.bar = builder.bar;
    }

    public String getFoo() {
        return foo;
    }

    public String getBar() {
        return bar;
    }

    public static class Builder {
        private String foo;
        private String bar;

        public Builder() {}

        public String getFoo() {
            return foo;
        }

        public Builder setFoo(String foo) {
            this.foo = foo;
            return this;
        }

        public String getBar() {
            return bar;
        }

        public Builder setBar(String bar) {
            this.bar = bar;
            return this;
        }

        public Foo build() {
            return new Foo(this);
        }
    }
}
