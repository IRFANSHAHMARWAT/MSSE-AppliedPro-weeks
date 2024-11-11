package WEEK_9;

class BrowserHistoryManagement_task3 {

    
    private class Node {
        String url;
        Node next;

        Node(String url) {
            this.url = url;
            this.next = null;
        }
    }

    private Node top; // Represents the top of the stack
    private int size; // Size of the stack

    public BrowserHistoryManagement_task3() {
        top = null;
        size = 0;
    }

    // Method to push a page onto the stack
    public void visitPage(String url) {
        Node newNode = new Node(url);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("Page '" + url + "' pushed into stack.");
    }

    // Method to go back (pop the last visited page)
    public void goBack() {
        if (top != null) {
            System.out.println("Going back from page: " + top.url);
            top = top.next;
            size--;
        } else {
            System.out.println("No pages to go back to.");
        }
    }

    // Method to get the total number of pages visited
    public int getTotalPagesVisited() {
        return size;
    }

    // Method to get the most recent page
    public String getMostRecentPage() {
        if (top != null) {
            return top.url;
        }
        return "No pages visited.";
    }

    // Method to get the oldest page
    public String getOldestPage() {
        if (top == null) {
            return "No pages visited.";
        }
        Node current = top;
        while (current.next != null) {
            current = current.next;
        }
        return current.url;
    }

    // Method to calculate the percentage of pages visited from a specific domain
    public double getDomainVisitPercentage(String domain) {
        int count = 0;
        Node current = top;
        while (current != null) {
            if (current.url.contains(domain)) {
                count++;
            }
            current = current.next;
        }
        return size == 0 ? 0 : ((double) count / size) * 100;
    }

    public static void main(String[] args) {
    	BrowserHistoryManagement_task3 browserHistory = new BrowserHistoryManagement_task3();

        // Simulate visiting pages
        browserHistory.visitPage("marwattech.com/home");
        browserHistory.visitPage("marwattech.com/contact");
        browserHistory.visitPage("marwat-tech.com/about");
        browserHistory.visitPage("marwattech.com/blog");

        // Display most recent and oldest page
        System.out.println("Recent page: '" + browserHistory.getMostRecentPage() + "'");
        System.out.println("Oldest page: '" + browserHistory.getOldestPage() + "'");

        // Display total pages visited
        System.out.println("Total pages visited: " + browserHistory.getTotalPagesVisited());

        // Calculate and display the percentage of pages visited from 'example.com'
        double percentageFromExample = browserHistory.getDomainVisitPercentage("example.com");
        System.out.printf("Percentage of pages visited from 'example.com': %.0f%%%n", percentageFromExample);
    }
}
