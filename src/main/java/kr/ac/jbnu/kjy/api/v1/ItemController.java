package kr.ac.jbnu.kjy.api.v1;

import kr.ac.jbnu.kjy.api.dto.ItemDto;
import kr.ac.jbnu.kjy.api.request.ItemCreateRequest;
import kr.ac.jbnu.kjy.api.request.ItemUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/items")

public class ItemController {

    private Map<Long, ItemDto> store = new HashMap<>();
    private Long sequence = 1L;

    @GetMapping // /api/v1/items 로 GET 요청 오면 이 메소드 실행
    public List<ItemDto> getItems() {

        return new ArrayList<>(store.values());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> getItem(@PathVariable Long id) {

        ItemDto item = store.get(id);

        if (item == null) {
            return ResponseEntity.notFound().build();
            // build() = body 없이 응답 생성
        }
        return ResponseEntity.ok(item);
    }

    @PostMapping
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemCreateRequest request) {

        // 새 ItemDto 객체 생성
        ItemDto item = new ItemDto();

        // 서버에서 id 자동 생성
        item.setId(sequence++);
        item.setName(request.getName());
        item.setPrice(request.getPrice());

        // store(Map)에 저장
        store.put(item.getId(), item);

        // 201 Created
        return ResponseEntity.status(201).body(item);
    }

    @PostMapping("/with-header")
    public ResponseEntity<String> createItemWithHeader(
            @RequestBody ItemCreateRequest request,
            @RequestHeader(value = "X-USER-ID", required = false) String userId,
            @RequestHeader(value = "Authorization", required = false) String authorization
    ) {
        // 응답 문자열 만들기
        StringBuilder sb = new StringBuilder();
        sb.append("요청한 아이템: ")
                .append(request.getName())
                .append(", price=")
                .append(request.getPrice())
                .append("\n")
                .append("X-USER-ID: ")
                .append(userId)
                .append("\n")
                .append("Authorization: ")
                .append(authorization);

        // 200 OK 및 생성된 문자열 반환
        return ResponseEntity.ok(sb.toString());
    }

    // 값 null이면 수정 안 함
    @PutMapping("/{id}")
    public ResponseEntity<ItemDto> updateItem(
            @PathVariable Long id,
            @RequestBody ItemUpdateRequest request
    ) {

        ItemDto item = store.get(id);

        // 404
        if (item == null) {
            return ResponseEntity.notFound().build();
        }

        if (request.getName() != null) {
            item.setName(request.getName());
        }

        if (request.getPrice() != null) {
            item.setPrice(request.getPrice());
        }

        // 200
        return ResponseEntity.ok(item);
    }

    // URL: PUT /api/v1/items/{id}/price?price=1234
    // URL로 price 받아 가격만 수정
    @PutMapping("/{id}/price")
    public ResponseEntity<ItemDto> updatePrice(
            @PathVariable Long id,
            @RequestParam Integer price // ?price=1234 받아옴
    ) {

        ItemDto item = store.get(id);
        // 404
        if (item == null) {
            return ResponseEntity.notFound().build();
        }
        // price 수정 및 200
        item.setPrice(price);
        return ResponseEntity.ok(item);
    }

    // Delete 2개
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {

        ItemDto item = store.get(id);
        // 404
        if (item == null) {
            return ResponseEntity.notFound().build();
        }
        // 있으면 삭제
        store.remove(id);
        // 204 No Content
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        store.clear(); // Map 전체 비우기
        return ResponseEntity.noContent().build(); // 204
    }
}