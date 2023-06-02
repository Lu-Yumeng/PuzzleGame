# PuzzleGame
## Module
- JFrame
  - 最外层的窗体
- JMenuBar
  - 最上层的菜单
  - JMenu
    - JMenuItem
- JLabel
  - 管理文字和图片的容器

## Window
- Main Window: 603*680
- Login Window: 488*430
- Register Window: 488*500

## x-y axis
- 图片左上角的位置是图片的位置
- JFrame 左上角为（0，0）

含有隐藏容器 : getContentPane()
default place at center
- setLayout(null) to stop display pic at center

## Event
- source: button/ image/ window
- event: click, keyboard input
- listen: when sth happened, execute sth
  - keyListener
    - keyPress
    - keyRelease
    - keTyped
  - MouseListener
    - Exit
    - Enter
    - Release
    - press
    - click
  - ActionListener

单击事件：
- ActionListener
- MouseListener onclick
- MouseListener release

路径：
- 绝对路径：盘符开始 
- 相对路径：相对当前项目而言的，在当前文件夹下寻找xxx

按住A不松开，显示完整图片
松开A显示随机打乱的图片