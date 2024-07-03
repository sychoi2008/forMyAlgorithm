package Algorithm;

import java.util.LinkedList;

class BrowserHistory {
    private LinkedList<String> linkedList = new LinkedList<>();
    int index = 0;
    public BrowserHistory(String homepage) {
        linkedList.add(homepage);
    }

    public void visit(String url) {
        index++;
        //linked list의 method 중 add는 인덱스를 지정하여 중간 삽입, 삭제가 가능함
        linkedList.add(index, url);
        // index + 1 = 진짜 원하는 linked list의 size
        // 근데, 그 원하는 사이즈보다 현재 linked list의 size가 더 클 동안
        // 언젠간 linked list = index + 1이 될 것임
        while(index+1 < linkedList.size()) {
            linkedList.removeLast();
        }
    }

    public String back(int steps) {
        // while문을 쓰지 않고 그냥 빼기해서 바로 접근
        int temp_index = index - steps;
        // 뺀 값이 0보다 작다면 맨 앞까지 가버린 것
        if(temp_index < 0) {
            // index를 0으로 바꾸고
            index = 0;
            // 0번째 인덱스 값 출력
            return linkedList.get(0);
        }
        // 뺐을 때 아직 linked list 안에 있는 index 값이라면
        // 그 값으로 초기화
        index = temp_index;
        // 출력
        return linkedList.get(index);

    }

    public String forward(int steps) {
        // 앞으로 가는 것도 마찬가지로 while문을 쓰지 않고 그냥 더하기로 바로 접근
        int temp_index = index+steps;
        // 하지만 더했을 때, linked list의 마지막 인덱스 값을 초과한다면 마지막 요소를 출력
        if(temp_index > linkedList.size()-1) {
            return linkedList.getLast();
        }
        // 아닐 경우는 index 값 업데이트 후 출력
        index = temp_index;
        return linkedList.get(index);

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
        browserHistory.visit("naver.com");
        System.out.println(browserHistory.forward(5));

    }
}

