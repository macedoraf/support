package rafael.macedo.supportbase.util

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.Window.FEATURE_NO_TITLE
import rafael.macedo.supportbase.R

/**
 * Created by Rafael Macedo on 23/02/2019
 */

 interface OnRetryListener{

    fun onClickRetry()

    fun onClickDontRetry()

}
class Dialog {

    companion object {

        private var loadingDialog:Dialog? = null

        fun showLoadingDialog(context: Context) {
            getInstanceLoadingDialog(context)?.show()

        }

        fun hideLoadingDialog(context: Context) {
            getInstanceLoadingDialog(context)?.dismiss()

        }

        private fun getInstanceLoadingDialog(context: Context):Dialog?{
            if(loadingDialog == null){
                val dialog = Dialog(context)
                dialog.requestWindowFeature(FEATURE_NO_TITLE)
                dialog.setContentView(R.layout.custom_dialog_layout)
                dialog.window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
                dialog.setCancelable(false)
                loadingDialog = dialog

            }

            return loadingDialog

        }

        private fun getInstanceRetryDialog(context: Context):Dialog?{
            if(loadingDialog == null){
                val dialog = Dialog(context)
                dialog.requestWindowFeature(FEATURE_NO_TITLE)
                dialog.setContentView(R.layout.custom_dialog_layout)
                dialog.window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
                dialog.setCancelable(false)
                loadingDialog = dialog

            }

            return loadingDialog

        }
    }
}