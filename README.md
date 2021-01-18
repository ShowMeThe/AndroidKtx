## Android-Ktx

提供各类对于Android常用方法的拓展，提高开发效率 (欢迎Star 和 pull request)

### 如何依赖：  
在build.gradle的dependencies添加需要的内容:
```gradle
implementation 'com.github.ShowMeThe:binding-ktx:1.0.0'
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
