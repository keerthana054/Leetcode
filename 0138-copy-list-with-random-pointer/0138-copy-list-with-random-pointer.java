class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node h = new Node(head.val);
        Node prev = h;
        Node p = head;
        head = head.next;
        Map<Node,Node> hm = new HashMap<>();
        hm.put(p,h);
        int i = 1;
        while(head!=null){
            Node n = new Node(head.val);
            prev.next = n;
            prev = n;
            hm.put(head,n);
            i++;
            head = head.next;
        }
        Node h1 = h;
        while(p!=null){
            if(p.random!=null){
                h1.random=hm.get(p.random);
            }
            h1 = h1.next;
            p=p.next;
        }
        return h;
    }
}