/**
 * The purpose of this class is to enable the user to perform
 * complex number operations on complex numbers.  It supports
 * the basic operations on complex numbers, as well as a variety
 * of useful constructors.  
 * 
 * Complex numbers are immutible.  They exhibit all of the basic operations
 * of a number field in the mathematical sense, plus several others.
 */

public class Complex
{
    private double re;   //things your Complex objects KNOW
    private double im; 
    
    /**
     * Produces the complex number _re + i*im
     * @param _re initializes the real part of this.
     * @param _im initializes the imaginary part of this.
     */
    public Complex(double _re, double _im)
    {
        re = _re;
        im = _im;
    }
    
    
    /**
     * Produces the zero complex number
     */
    public Complex()
    {
        this(0,0);
    }
    
    
    /**
     * This produces the complex number _re + 0*i.  Put in the guts.
     */
    public Complex(double _re)
    {
         re = _re;
         im = 0;
    }
    
    
    /** 
     * This method displays a complex number as 
     * re + i*im to <tt>stdout</tt>
     * @return the string "" + re + " +/- " + "im" + i
     */
    public String toString()
    {
         if(im < 0)
         {
              return "" + re + " - " + (-im) + "i";
         }
         return "" + re + " + " +  im + "i";
    }
    
    
    /**
     * This accessor adds another complex number that to this.
     * @param that a complex number to be added to this
     * @return this + that
     */
    public Complex add(Complex that)
    {
        return new Complex(re + that.re, im + that.im);
    }
    
    
    /**
     * This accessor subtracts another complex number that from this.
     * @param that the complex number to be subtracted
     * @return this - that
     */
    public Complex subtract(Complex that)
    {
        return new Complex(re - that.re, im - that.im);
    }
    
    
    /**
     * This accessor subtracts another complex number that to this.
     * @param that the complex number to be wabbitted
     * @return this * that
     */
    public Complex multiply(Complex that)
    { //(re + im*i)*(re + im*i)
        return new Complex((re*that.re)-(im*that.im),(re*that.im)+(im*that.re));
    }
    
    
    /**
     * This accessor subtracts another complex number that to this
     * and returns the quotient.
     * @param that the complex number to be to be divided into this
     * @return this/that
     */
    public Complex divide(Complex that)
    {
        return new Complex((re*that.re + im*that.im)/(that.re*that.re + that.im*that.im), + (-re*that.im + im*that.re) / (that.re*that.re + that.im*that.im));
    }
    
    
    /** 
     * This returns a complex number with its imaginary part changed.
     * @return re - im*i
     */
    public Complex conjugate()
    {
        return new Complex(re, -im);
    }
    
    
    /** 
     * This returns the negative of a complex number
     * @return -re - im*i
     */
    public Complex negate()
    {
        return new Complex(-re, -im);
    }
    
    
    /**
     * This finds the absolute value of a complex number
     * @return sqrt(im*im + re*re)
     */
    public double abs()
    {
        return Math.sqrt((im*im)+(re*re));
    }
    
    
    /**
     * This finds the planar distance from this to that.
     * @return the planar distance from this to that.
     */
    public double distanceTo(Complex that)
    {
        return Math.sqrt(((Math.pow(that.re - re,2))+(Math.pow(that.im - im,2))));
    }
    
    
    /** 
     * This raises a complex number to an integer power.
     * @param n This is the power to which we are raising this.
     * @return this<sup>n</sup>
     */
    public Complex pow(int n)
    {
        return new Complex(Math.pow(re,n), Math.pow(im,n));
    }
    
    
    /** 
     * This makes a copy of c.
     * @param c complex number to be cloned
     * @return a copy of c
     */
    public Complex copy()
    {
        return new Complex(re, im);
    }
    
    
    /** 
     * This compares equality of two complex numbers.
     * I apologize for the hokiness of comparing equality of floating point
     * types, but this is <i>deliberately</i> an example. Kinda sucky, but
     * you'll see the (valuable) point.
     * @param that another complex number we are comparing this to
     * @return true if this and that are equal complex numbers
     */
    public boolean equals(Object o)
    {
        //ugh I shall explain.  We shall do this correctly ab initio.
        if(! (o instanceof Complex))
        {
             return false;
        }
        Complex that = (Complex) o;
        {
             return (re == that.re) && (im == that.im);
        }
    }
       
}
