package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {
    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") //조인 컬럼 주인
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delevery_id")
    private Delivery delivery;

    private LocalDateTime orderDate; //주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; //주문상태 오더랑 캔슬 두가지 상태

    //====연관관계 편의 메서드
    public void setMember(Member member) {
        this.member = member;
        member.getOrder().add(this);
        //멤버와 오더 둘다 편리하게 넣을 수 있음
        //핵심적인 컨트롤 하는데에 있는게 좋다
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }
    //주문 생성 메서드
    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) {
        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);
        for(OrderItem orderItem : orderItems){
            order.addOrderItem(orderItem);
        }
        order.setStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDateTime.now());
        return order;
    }
    public void cancel(){
        if(delivery.getStatus() == DeliveryStatus.COMP){
            throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다.");
        }
        this.setStatus(OrderStatus.CANCEL);
        for(OrderItem orderItem : orderItems){
            orderItem.cancel();
        }
    }

        public int getTotalPrice(){
            int totalPrice = 0;
            for(OrderItem orderItem : orderItems){
                totalPrice += orderItem.getTotalPrice();
            }
            return totalPrice;
        }
    }
    /*
    원래 비지니스 로직

    public static void main(String[] args) {
        Member member = new Member();
        Order order = new Order();

        order.setMember(member); 오더가 핵심 비지니스로직
    }
    */
    /*
    원래 비지니스 로직

    public static void main(String[] args) {
        Member member = new Member();
        Order order = new Order();

        member.getOrder().add(order);
        order.setMember(member);
    }
    */

}
