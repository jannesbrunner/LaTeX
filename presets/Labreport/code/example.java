package mypckg;

public class RunClassForName
{
  public static void main( String[] args ) throws Exception
  {
    if( 1 > args.length ) {
      System.out.println( "Klassenname (z.B. 'mypckg.MyClass1') als Parameter benoetigt." );
      System.exit( 1 );
    }
    Object obj = instantiateClassForName( args[0] );
    if( obj instanceof Runnable )
      ((Runnable)obj).run();
    else
      System.out.println( obj );
  }

  public static Object instantiateClassForName( String className ) throws Exception
  {
    Class c = Class.forName( className );
    if( null == c )
      throw new Exception( "Error: Unable to access class '" + className + "'." );
    Object o = c.newInstance();
    if( null == o )
      throw new Exception( "Error: Unable to create instance of class '" + className + "'." );
    return o;
  }
}


