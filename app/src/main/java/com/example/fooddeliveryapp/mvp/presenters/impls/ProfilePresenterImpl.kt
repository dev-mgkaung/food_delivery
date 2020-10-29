import android.graphics.Bitmap
import androidx.lifecycle.LifecycleOwner
import com.example.fooddeliveryapp.datas.models.AuthenticationModel
import com.example.fooddeliveryapp.datas.models.AuthenticationModelImpl
import com.example.fooddeliveryapp.datas.models.FoodDeliveryModel
import com.example.fooddeliveryapp.datas.models.FoodDeliveryModelImpl
import com.example.fooddeliveryapp.mvp.presenters.ProfilePresenter
import com.example.fooddeliveryapp.mvp.views.ProfileView
import mk.padc.share.mvp.presenters.AbstractBasePresenter

class ProfilePresenterImpl : ProfilePresenter, AbstractBasePresenter<ProfileView>() {

    private val mAuthenticationModel: AuthenticationModel = AuthenticationModelImpl

    private  val foodDeliveryModel : FoodDeliveryModel = FoodDeliveryModelImpl

    override fun updateUserProfile(bitmap: Bitmap) {
        foodDeliveryModel.uploadProfileImage(bitmap,
        onSuccess = {
            mView?.onTapSaveUserData()
            mAuthenticationModel.updateProfile(it,onSuccess = {}, onFailure = {})
        },
        onFailure = {
            mView?.showError("Profile Updat Failed")
            mView?.onTapSaveUserData()
        })

      //  mView?.onTapSaveUserData()
    }

    override fun onTapCancelUserData() {
        mView?.onTapCancelUserData()
    }

    override fun onTapEditProfileImage() {
        mView?.onTapEditProfileImage()
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mAuthenticationModel?.userData(
                onSuccess = {
                    mView?.displayUserData(it)
                },
                onFailure = {}
        )
    }
}

