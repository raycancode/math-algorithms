# Math Algorithms

1. Valid Palindrome (`isPalindrome`)

- Ý tưởng: Dùng 2 con trỏ trái/phải, bỏ qua ký tự không hợp lệ (không phải chữ thường hoặc số), so sánh ký tự sau khi đưa chuỗi về lowercase.

2. Power of Three (`isPowerOfThree`)

- Ý tưởng: Số lớn nhất là lũy thừa của 3 trong `int` là `1162261467` (`3^19`).
- Kiểm tra `n > 0` và `1162261467 % n == 0` thì `n` là lũy thừa của 3.

3. House Robber (`rob`)

- Ý tưởng: Quy hoạch động 1 chiều.
- `dp[i]` là số tiền lớn nhất cướp được đến nhà `i`.
- Công thức: `dp[i] = max(dp[i-1], dp[i-2] + nums[i])`.

4. Rotate Image (`rotate`)

- Ý tưởng: Xoay ma trận `n x n` 90 độ theo chiều kim đồng hồ bằng 2 bước:
- Bước 1: Chuyển vị ma trận theo đường chéo chính.
- Bước 2: Đảo cột trái/phải (reverse theo chiều ngang).

5. First Bad Version (`firstBadVersion`)

- Ý tưởng: Tìm kiếm nhị phân trên đoạn `[1..n]` để tìm vị trí bad đầu tiên.
- Nếu `isBadVersion(mid)` đúng thì co biên phải, ngược lại dời biên trái.

6. Group Anagram (`isAnagram`, `groupAnagrams`)

- `isAnagram`: Dùng mảng đếm tần suất 26 chữ cái để so sánh hai chuỗi.
- `groupAnagrams`: Sort ký tự từng chuỗi để tạo khóa chuẩn, gom nhóm bằng `HashMap<String, List<String>>`.

7. Increasing Triplet Subsequence (`increasingTriplet`)

- Ý tưởng: Theo dõi hai mốc nhỏ nhất `first`, `second`.
- Khi gặp phần tử lớn hơn cả `first` và `second` thì đã tồn tại bộ ba tăng dần.

8. Jump Game II (`jump`)

- Ý tưởng: Greedy theo từng "lớp phạm vi nhảy".
- `maxFar` là vị trí xa nhất hiện tại có thể với tới, `currEnd` là biên của số bước hiện tại.
- Khi tới `currEnd` thì tăng số bước nhảy.

9. Candy (`candy`)

- Ý tưởng: Hai lượt duyệt mảng để đảm bảo cả hai điều kiện trái/phải.
- Lượt trái -> phải xử lý quan hệ tăng với hàng xóm trái.
- Lượt phải -> trái xử lý quan hệ tăng với hàng xóm phải.

10. Remove Boxes (`removeBoxes`)

- Ý tưởng: Quy hoạch động 3 chiều + đệ quy nhớ trạng thái.
- Trạng thái `dp[i][j][k]`: điểm tối đa cho đoạn `[i..j]` khi có thêm `k` hộp cùng màu với `boxes[i]` được gộp vào bên trái.
