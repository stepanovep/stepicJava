public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() { return re; }

    public double getIm() { return im; }

    @Override
    public boolean equals (Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        ComplexNumber b = (ComplexNumber)obj;
        return (Math.abs(re-b.re) < 1e-9 && Math.abs(im-b.im) < 1e-9);
    }

    @Override
    public int hashCode() {
        Double h = re * im;
        return h.hashCode();
    }
}