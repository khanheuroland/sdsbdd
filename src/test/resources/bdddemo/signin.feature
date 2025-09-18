Feature: Sign In with Email and Password

  Scenario: Error message will show after sign in with invalid email format
    Given The sign in page is showed
    When The user attempt to sign in with invalid email format
    Then The message "- Vui lòng nhập Email đúng định dạng" will be showed.

  Scenario: Hiển thị thông báo thiếu dữ liệu cho username và password
    Given Mở trang Sign In
    When Khi người dùng thực hiện sign in với username và password rỗng
    Then Thông báo "Vui lòng nhập dữ liệu" sẽ hiển thị bên dưới.

  Scenario: Hiển thị thông báo lỗi khi sigin với mật khẩu sai
    Given Mở trang Sign In
    When Người dùng thực hiện sign in với username "khanh.tx@live.com" và mật khẩu "abc123"
    Then Thông báo "- Mật khẩu không đúng, vui lòng kiểm tra lại" sẽ hiển thị

  Scenario: Hiển thị thông báo lỗi khi sigin với username không đúng
    Given Mở trang Sign In
    When Người dùng thực hiện sign in với username "khanh.tx123@live.com" và mật khẩu "abc123"
    Then Thông báo "- Tài khoản không tồn tại, vui lòng kiểm tra lại" sẽ hiển thị