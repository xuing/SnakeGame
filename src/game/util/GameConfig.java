package game.util;
//≈‰÷√–≈œ¢
public class GameConfig {
	private static String skinPath = "Classic";
	private static int cellSize = 40;
	private static int rows = 11;
	private static int cols = 20;
	
	public static int getClientWidth(){
		return cols * cellSize + 4 +8;
	}
	
	public static int getClientHeight(){
		return rows * cellSize + 4 +70;
	}
	
	public static int getCellSize() {
		return cellSize;
	}

	public static int getRows() {
		return rows;
	}

	public static int getCols() {
		return cols;
	}

	public static String getSkinPath() {
		return skinPath;
	}

	public static void setSkinPath(String skinPath) {
		GameConfig.skinPath = skinPath;
	}
}
