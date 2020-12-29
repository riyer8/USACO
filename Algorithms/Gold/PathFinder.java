import java.util.*;
import java.awt.geom.Point2D;

// implementations of A* and Dijkstra's algorithm
// both algorithms use the same code except Dijkstra's has no heuristic value

class Node {
	int id;
	Set<Node> children = new HashSet<Node>();	
	
	public Node(int id) {
		this.id = id;
	}
	public void addNode(Node child) {
		children.add(child);
	}
	public Set<Node> getChildren() {
		return children;
	}
	public boolean equals(Node o) {
		return id == o.id;
	}
	public String toString() {
		return "{Node ID: " + id + "}";
	}
}
class Weight {
	HashMap<Node, Map<Node, Double>> map = new HashMap<Node, Map<Node, Double>>();
	public void set(Node tail, Node head, double weight) {
		map.putIfAbsent(tail, new HashMap<Node, Double>());
		map.get(tail).put(head, weight);
	}
	public double getWeight(Node tail, Node head) {
		return map.get(tail).get(head);
	}
}
class Coordinates {
	Map<Node, Point2D.Double> map = new HashMap<Node, Point2D.Double>();
	public void put (Node node, Point2D.Double point) {
		map.put(node, point);
	}
	public Point2D.Double getPoint(Node node) {
		return map.get(node);
	}
}
interface HeuristicFunction {
	public double getEstimate(Node node1, Node node2);
}
class ZeroHF implements HeuristicFunction{
	public double getEstimate (Node node1, Node node2) {
		return 0.0;
	}
}
class EuclideanHF implements HeuristicFunction{
	Coordinates coordinates;
	public EuclideanHF(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	
	public double getEstimate(Node node1, Node node2) {
		return coordinates.getPoint(node1).distance(coordinates.getPoint(node2));
	}
}
class HeapEntry implements Comparable<HeapEntry>{
	Node node;
	double distance;
	HeapEntry(Node node, double distance) {
		this.node = node;
		this.distance = distance;
	}
	Node getNode() {
		return node;
	}
	public int compareTo(HeapEntry o) {
		return Double.compare(distance, o.distance);
	}
}
class AStar {
	public static ArrayList<Node> search(Node source, Node target, Weight weightfunction, HeuristicFunction heuristicfunction) {
		PriorityQueue<HeapEntry> open = new PriorityQueue<>(); //nodes to check
		Set<Node> closed = new HashSet<>(); //best estimate we know
		Map<Node, Double> distance = new HashMap<>(); //distances from the end point
		Map<Node, Node> parents = new HashMap<>(); //helps reconstruct the best path
		
		open.add(new HeapEntry(source, 0.0));
		distance.put(source, 0.0);
		parents.put(source, null);
		
		while(!open.isEmpty()) {
			Node currentNode = open.remove().getNode();
			if (currentNode.equals(target)) {
				return tracebackPath(currentNode, parents);
			}
			if (closed.contains(currentNode)) continue;
			closed.add(currentNode);
			for (Node childNode: currentNode.getChildren()) {
				if (closed.contains(childNode)) continue;
				double tentativeDistance = distance.get(currentNode) + weightfunction.getWeight(currentNode,childNode);
				if (!distance.containsKey(childNode) || distance.get(childNode)>tentativeDistance) {
					distance.put(childNode, tentativeDistance);
					parents.put(childNode, currentNode);
					open.add(new HeapEntry(childNode,tentativeDistance+heuristicfunction.getEstimate(childNode,target)));
				}
			}
		}
		return new ArrayList<>(); //if target is not reachable
	}
	public static ArrayList<Node> tracebackPath(Node target, Map<Node, Node> parents) {
		ArrayList<Node> path = new ArrayList<>();
		Node currentNode = target;
		while(currentNode != null) {
			path.add(currentNode);
			currentNode = parents.get(currentNode);
		}
		
		Collections.reverse(path); //path reversed to go from starting node to target node
		
		return path;
	}
}
class Dijkstra1 {
	public static ArrayList<Node> search(Node source, Node target, Weight weightfunction) {
		return AStar.search(source, target, weightfunction, new ZeroHF()); //uses a 0.0 heuristic value unlike A*
	}
}
public class PathFinder {
	public static void main(String[] args) throws Exception {
		
		long seed = System.nanoTime();
		Random random = new Random(seed);
		//implements a random graph
		
		ArrayList<Node> graph = getRandomGraph(10000,50000, random);
		Coordinates coordinates = getCoordinates(graph, random);
		Weight weightfunction = getweightfunction(graph, coordinates);
		
		Node source = choose(graph, random);
		Node target = choose(graph, random);
		
		System.out.println("Source: " + source);
		System.out.println("Target: " + target);
		
		HeuristicFunction hf = new EuclideanHF(coordinates);
		
		//print-outs
		long start = System.currentTimeMillis();
		ArrayList<Node> path1 = AStar.search(source, target, weightfunction, hf);
		long end = System.currentTimeMillis();
		System.out.println();
		System.out.println("A* in " + (end-start) + " milliseconds");
		path1.forEach(System.out::println);
		
		start = System.currentTimeMillis();
		ArrayList<Node> path2 = Dijkstra1.search(source, target, weightfunction);
		end = System.currentTimeMillis();
		System.out.println();
		System.out.println("Dijkstra in " + (end-start) + " milliseconds");
		path2.forEach(System.out::println);
		
		System.out.println("Algorithms agree: " + path1.equals(path2));
	}
	public static ArrayList<Node> getRandomGraph(int nodes, int arcs, Random random) {
		ArrayList<Node> graph = new ArrayList<Node>(nodes);
		for (int id = 0; id<nodes; id++) {
			graph.add(new Node(id));
		}
		while(arcs >0) {
			Node tail = choose(graph, random);
			Node head = choose(graph, random);
			tail.addNode(head);
			arcs--;
		}
		return graph;
	}
	public static Coordinates getCoordinates(ArrayList<Node> graph, Random random) {
		Coordinates coordinates = new Coordinates();
		for (Node node: graph) {
			coordinates.put(node, randomPoint(1000.0, 1000.0, random));
		}
		return coordinates;
	}
	public static Weight getweightfunction(ArrayList<Node> graph, Coordinates coordinates) {
		Weight weightFunction = new Weight();
		for (Node node: graph) {
			Point2D.Double p1 = coordinates.getPoint(node);
			for (Node child: node.getChildren()) {
				Point2D.Double p2 = coordinates.getPoint(child);
				double distance = p1.distance(p2);
				weightFunction.set(node, child, 1.2*distance);
			}
		}
		return weightFunction;
	}
	public static Point2D.Double randomPoint( double width, double height, Random random) {
		return new Point2D.Double(width*random.nextDouble(), height*random.nextDouble());
	}
	public static <T> T choose(ArrayList<T> list, Random random) {
		return list.get(random.nextInt(list.size()));
	}
}

//link I used to walk-through the code: https://www.youtube.com/watch?v=uPXlsSd_wK4
