# MbileAppATeamG2
大学の集中講義，アンドロイドアプリ開発Aで使用

# 設計
早起き支援（バツゲーム）

- 起きるボタンがある画面が，起動時に最初に表示される.

永続データの保存はキーバリューストアで行う
- 残高ポイント名 `RemainPoints`
- 設定時間 Calenderクラスから時間と分を整数型で取り出せそう `WakeUpHour`, `WakeUpMinute`
- 口座番号（仮） `CreditNumber`

