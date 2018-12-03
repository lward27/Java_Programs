private static Singleton singleton;

public static Singleton getInstance() {
	if(singleton doesn't exist) {
		singleton = new Singleton();
	}
	return singleton;
}

Singleton s = Singleton.getInstance(); //from client code...
