package kr.ac.jbnu.kjy.api.dto;

public class ItemDto {

    // id: 아이템의 고유 번호(키). Long 타입(큰 정수)을 사용
    private Long id;

    // name: 아이템 이름(문자열)
    private String name;

    // price: 아이템 가격(정수, null 가능하니까 Integer)
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
