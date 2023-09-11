package cz.jh.fastchem;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Licenses extends MainActivity {
    TextView license_label;
    Button license_pdf;
    Button license_fastchem;
    Button licensing_terms_fastchem;
    Button license_transpose;
    Button license_android_shell;
    Button license_eigen3;
    Button licensing_terms_eigen3;
    Button quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.licenses);

        license_label = (TextView) findViewById(R.id.license_label);

        license_pdf = (Button) findViewById(R.id.license_pdf);
        license_pdf.setOnClickListener(license_pdfClick);
        license_fastchem = (Button) findViewById(R.id.license_fastchem);
        license_fastchem.setOnClickListener(license_fastchemClick);

        licensing_terms_fastchem = (Button) findViewById(R.id.licensing_terms_fastchem);
        licensing_terms_fastchem.setOnClickListener(licensing_terms_fastchemClick);
        license_transpose = (Button) findViewById(R.id.license_transpose);
        license_transpose.setOnClickListener(license_transposeClick);

        license_android_shell = (Button) findViewById(R.id.license_android_shell);
        license_android_shell.setOnClickListener(license_android_shellClick);

        license_eigen3 = (Button) findViewById(R.id.license_eigen3);
        license_eigen3.setOnClickListener(license_eigen3Click);

        licensing_terms_eigen3 = (Button) findViewById(R.id.licensing_terms_eigen3);
        licensing_terms_eigen3.setOnClickListener(licensing_terms_eigen3Click);

        quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Licenses.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private View.OnClickListener license_pdfClick; {
        license_pdfClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1pdf();
            }
        };
    }

    public void alert1pdf() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-ACPDFVIEW")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-ACPDFVIEW.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license_android_shellClick; {
        license_android_shellClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1as();
            }
        };
    }

    public void alert1as() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-ANDROID-SHELL")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-ANDROID_SHELL.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license_eigen3Click; {
        license_eigen3Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1eigen3();
            }
        };
    }

    public void alert1eigen3() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-EIGEN3")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-EIGEN3.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener licensing_terms_eigen3Click; {
        licensing_terms_eigen3Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert2eigen3();
            }
        };
    }

    public void alert2eigen3() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSING-TERMS-EIGEN3")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSING-TERMS-EIGEN3.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license_fastchemClick; {
        license_fastchemClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1fastchem();
            }
        };
    }

    public void alert1fastchem() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-FASTCHEM")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-FASTCHEM.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener licensing_terms_fastchemClick; {
        licensing_terms_fastchemClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert2fastchem();
            }
        };
    }

    public void alert2fastchem() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSING-TERMS-FASTCHEM")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSING-TERMS-FASTCHEM.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license_transposeClick; {
        license_transposeClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1transpose();
            }
        };
    }

    public void alert1transpose() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-TRANSPOSE")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-TRANSPOSE.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }



    // Executes UNIX command.
    private String exec(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            int read;
            char[] buffer = new char[4096];
            StringBuffer output = new StringBuffer();
            while ((read = reader.read(buffer)) > 0) {
                output.append(buffer, 0, read);
            }
            reader.close();
            process.waitFor();
            return output.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
