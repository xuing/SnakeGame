package game.model;

import java.awt.Graphics;
import java.util.ArrayList;

import game.util.GameConfig;

/**
 * ������������װ��Ϸ������ص����ݺ���Ϊ��
 * ��Ϣ�����ڵ㼯������ȣ����ܰ����ߵ��ƶ���
 * ת����������ʳ��ͼ��ȡ�
 * @author ����
 *
 */

public class Snake {
	private ArrayList<Node> nodes = new ArrayList<>();
	private Direction direction = Direction.Right;
	private int[][] offsets = {{0,-1},{-1,0},{0,1},{1,0}};
	
	public Snake() {
		init();
	}
	
	public void init(){
		nodes.clear();
		int r = GameConfig.getRows() /2;
		nodes.add(new Node(r, 0));
		nodes.add(new Node(r, 1));
		nodes.add(new Node(r, 2));
		direction = Direction.Right;
	}
	
	public void draw(Graphics g){
		for (Node n : nodes) {
			n.draw(g);
		}
	}
	
	public void grow(Node n){
		n.setType(NodeType.Snake);
		nodes.add(n);
	}
	
	public void turnTo(Direction direction){
		this.direction = direction;
	}
	
	public boolean isEat(Node food) {
		Node head = nodes.get(nodes.size() -1);
		Node next = new Node(head.getRow(), head.getCol());
		next.setCol(head.getCol() + offsets[direction.ordinal()][1]);
		next.setRow(head.getRow() + offsets[direction.ordinal()][0]);
		return next.equals(food);
	}
	
	public void move(){
		for(int i = 0; i < nodes.size() - 1; i++){
			Node n =nodes.get(i), next = nodes.get(i+1);
			n.setRow(next.getRow());
			n.setCol(next.getCol());
		}
		Node head = nodes.get(nodes.size() -1);
		head.setCol(head.getCol() + offsets[direction.ordinal()][1]);
		head.setRow(head.getRow() + offsets[direction.ordinal()][0]);
	}

	public boolean overlap(Node n) {
		boolean s = false;
		for(Node node : nodes)
			if(node.equals(n)){
				s = true;
				break;
			}
		return s;
	}

	public boolean validate() {
		return checkCollision() && checkSelf();
	}

	private boolean checkSelf() {
		Node head = nodes.get(nodes.size() -1);
		Node next = new Node(head.getRow(), head.getCol());
		next.setCol(head.getCol() + offsets[direction.ordinal()][1]);
		next.setRow(head.getRow() + offsets[direction.ordinal()][0]);
		return !overlap(next);
	}

	private boolean checkCollision() {
		Node head = nodes.get(nodes.size() -1);
		int r = head.getRow() + offsets[direction.ordinal()][0];
		int c = head.getCol() + offsets[direction.ordinal()][1];
		return (r >= 0 && r < GameConfig.getRows()) && (c >= 0 && c < GameConfig.getCols());
	}
	
}
