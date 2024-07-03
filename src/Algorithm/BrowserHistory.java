package Algorithm;

import java.util.LinkedList;

class BrowserHistory {
    String homepage;
    LinkedList<String> pages;

    // 현재 페이지를 가르키는 변수
    int current_index;

    public BrowserHistory(String homepage) {
        this.homepage = homepage;
        pages = new LinkedList<>();
        pages.add(homepage);
        current_index = 0;
    }

    public void visit(String url) {
        if(current_index == pages.size() - 1) {
            pages.add(url);
            current_index++;
        } else {
            current_index++;
            pages.set(current_index, url);
        }
    }

    public String back(int steps) {
        while(steps > 0 && current_index != 0) {
            current_index--;
            steps--;
        }
        return pages.get(current_index);
    }

    public String forward(int steps) {
        while(steps > 0 && current_index != pages.size()-1) {
            current_index++;
            steps--;
        }
        return pages.get(current_index);
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("linkedin.com");
        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));
    }
}

