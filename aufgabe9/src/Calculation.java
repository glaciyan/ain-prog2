public record Calculation(double x, double y) {
    public double sum() {
        return x + y;
    }

    public double minus() {
        return x - y;
    }

    public double mul() {
        return x * y;
    }

    public double division() {
        return x / y;
    }

    public double potenz() {
        return Math.pow(x, y);
    }

    public double sin(boolean rad) {
        if (rad) return Math.sin(Math.toRadians(x));
        return Math.sin(x);
    }

    public double cos(boolean rad) {
        if (rad) return Math.cos(Math.toRadians(x));
        return Math.cos(x);
    }

    public double log2() {
        return Math.log(x) / Math.log(2);
    }
}
