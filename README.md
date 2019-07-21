# CommonRemoveBlackPage
解决android

### 截图：
gif图展示了android冷启动的过程，没有任何黑画和白画效果，直接进入了程序。两张演示demo是沉浸式状态栏效果，你过你想不显示状态栏和导航栏只要在主题中设置下全屏即可.

#### 截图方案1：
<div>
<img src="capture/1.png" width="30%" />
<img src="capture/2.png" width="30%" />
<img src="capture/方案1-demo.gif" width="30%" />
</div>

#### 截图方案2 && 方案3错误写法演示 && 方案三正确写法演示：
<div>
<img src="capture/方案2-demo.gif" width="30%" />
<img src="capture/方案3-error-demo.gif" width="30%" />
<img src="capture/方案3-正确使用demo.gif" width="30%" />
</div>

#### 版本说明，分别展示每个方案的代码版本

##### 方案一代码,demo，gif的版本。
<span>
<img src="capture/方案1-demo-code-flag.png" width="100%" />
</span>

##### 方案二代码,demo，gif的版本。
<span>
<img src="capture/方案2-demo-code-flag.png" width="100%" />
</span>

##### 方案三代码,demo，gif的版本。
<span>
<img src="capture/方案3-正确使用demo-code-flag.png" width="100%" />
</span>

### 方案说明：
    
    
    
    
 ### 参考：   
  另外，借鉴了如下两个文章关于解决黑画问题的思路，写的不错，也推荐下，我主要是理清了三种实现的步骤并且整理出一个demo去实践下，并且分析了单独应用场景和多应用车机场景的优劣区别，需要你根据自己的需求去选择使用。 没有最好的 方案，是有最适合你的方案，比如方案三其实是不错的方案，能够最大的优化启动时间并且能够自然过渡，只是规则复杂需要你懂得它对时序的破坏不要影响了逻辑造成bug即可，但是因为我们的车机需求是不能每个应用启动都带一个过渡动画，显得很繁琐，所以就使用了透明延迟一点的方案。
  https://www.jianshu.com/p/0026a01c6811
  https://juejin.im/post/5d1bb7c6f265da1ba84aab1c
 
  
  
