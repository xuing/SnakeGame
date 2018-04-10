/**
 * ��������:��Ϸ����С��ɵ�Ԫ
 * ���Ա�ʾ�ߵĽڵ㡢ʳ��ϰ���ڵ�
 * Ӧ�ð���λ����Ϣ���ڵ�������Ϣ����Ҫ�ṩ�еȷ�����
 * */
package game.model;

import java.awt.Graphics;
import java.awt.Image;

import game.util.GameConfig;
import game.util.GameImages;

public class Node {
	private int row;
	private int col;
	private NodeType type;
	
	public Node(int r,int c){
		this(r, c, NodeType.Snake);
	}
	
	public Node(int r, int c, NodeType t) {
		row = r;
		col = c;
		type = t;
	}
	
	public void draw(Graphics g){
		int size = GameConfig.getCellSize();
		int x = col * size + 2 , y = row * size + 2;
		Image img = GameImages.getnode(type.ordinal());
		g.drawImage(img, x, y, size, size, null);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Node n = (Node)obj;
		return row == n.row && col == n.col;
	}

	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public NodeType getType() {
		return type;
	}
	public void setType(NodeType type) {
		this.type = type;
	}
}
