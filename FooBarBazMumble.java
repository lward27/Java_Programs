public class FooBarBazMumble
{
	public static void main(String[] args)
	{
		foo();
		bar();
	}

	public static void foo()
	{
		System.out.println("foo");
		mumble();
		System.out.println();
	}
	
	public static void bar()
	{
		System.out.println("bar");
		baz();
	}

	public static void baz()
	{
		System.out.println("baz");
		mumble();
	}

	public static void mumble()
	{
		System.out.println("mumble");
	}
}
