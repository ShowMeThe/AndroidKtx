## Android-Ktx

提供各类对于Android常用方法的拓展，提高开发效率 (欢迎Star 和 pull request)
<p align="center">
    <img src="https://camo.githubusercontent.com/53a976ec54e1b056df2c0d7121a1e1d56e2539c24ba601f3672f0a03541dcb4e/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6c616e67756167652d6b6f746c696e2d6f72616e67652e737667"/>  <img src="https://img.shields.io/badge/Author-ShowMeThe-orange"/> 
    </>
</p>


### 如何依赖：  
在build.gradle的dependencies添加需要的内容:
```gradle
implementation 'com.github.ShowMeThe:binding-ktx:1.0.1' //一行代码实现ViewBinding和DataBinding
implementation 'com.github.ShowMeThe:span-ktx:1.0.0' // SpannableStringBuilder拓展快速编写
```


### 主要内容：  
    1、 一行代码实现ViewBinding和DataBinding的使用，并加入生命周期的监听（ViewBinding利用到了反射，已添加混淆内容）  
    2、 对SpannableStringBuilder进行拓展快速编写
    
    


## Example：  
### 1 、 一行代码实现ViewBinding和DataBinding
```kotlin

class MainActivity : AppCompatActivity() {

    var binding by BindingProperty<ActivityMainBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = binding(this,R.layout.activity_main)

        binding.tv1.setOnClickListener {
            Toast.makeText(this,"Click Event",Toast.LENGTH_LONG).show()
        }

    }
}

```
BindingProperty的作用是对作用域为Lifeowner的作用域进行生命周期的监听，例如DataBinding在布局中直接写入的Livedata就利用这点了，需要传入Lifeowner  
或者使用如下：
```kotlin
class MainActivity : AppCompatActivity() {

    val binding by lazy { binding<ActivityMainBinding>(this,R.layout.activity_main) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.tv1.setOnClickListener {
            Toast.makeText(this,"Click Event",Toast.LENGTH_LONG).show()
        }


    }
}
```
#### 注意事项：  
    1 、binding方法对ComponentActivity，无论ViewBinding还是DataBinding都进行了setContentView的操作，留意的重复输入问题
    
### 2、SpannableStringBuilder拓展
模板代码如下：
```kotlin
class MainActivity : AppCompatActivity() {

    val binding by lazy { binding<ActivityMainBinding>(this,R.layout.activity_main) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val text = "测试内容演示Spannable"


        binding.apply {

            tv1.movementMethod = LinkMovementMethod.getInstance()
            tv1.setHintTextColor(Color.TRANSPARENT)
            tv1.text = text.span.apply {
                foregroundColor(Color.RED,0..7)
                italic(0..2)
                backgroundColor(Color.LTGRAY,0..3)
                underline(0..2)
                strikeThrough(6..9)
                bold(2..4)
                boldItalic(6..9)
                size(25,0..1)
                sizeRelative(2f,1..2)
                val drawable = ContextCompat.getDrawable(this@MainActivity,R.mipmap.ic_launcher_round)
                drawable!!.setBounds(0,0,drawable.intrinsicHeight,drawable.intrinsicWidth)
                image(drawable,0..1)
                click(10..12){
                    Toast.makeText(this@MainActivity, text,Toast.LENGTH_LONG).show()
                }
            }

        }


    }
}
```  
效果图：  
<img src="https://github.com/ShowMeThe/AndroidKtx/blob/master/img/example.jpg" width = 400 alt = "example" />
